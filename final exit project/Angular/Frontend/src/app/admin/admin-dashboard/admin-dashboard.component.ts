import { Component, OnInit } from '@angular/core';
import { Ticket } from 'src/app/models/ticket';
import { TicketService } from 'src/app/services/ticket.service';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {
  data: boolean = false;
  searchActivate: boolean = false;
  search: string = '';
  searchBy: string = '';
  sortBy: string = '';
  pageNo: number = 0;
  params: string = `size=5&page=`;
  ticketData: Ticket[];
  lastpage: boolean;
  firstpage: boolean;
  tickets: boolean = true;
  constructor(private ticketService: TicketService) { }

  ngOnInit(): void {
    this.fetch('', '', this.pageNo, '');
  }
  nextClick() {
    this.pageNo++;
    if (this.sortBy.length == 0 && !this.searchActivate)
      this.fetch('', '', this.pageNo, '');
    else if (this.sortBy.length != 0 && !this.searchActivate)
      this.fetch('', '', this.pageNo, "&sort=" + this.sortBy);
    else if (this.sortBy.length == 0 && this.searchActivate)
      this.fetch(this.searchBy, this.search, this.pageNo, '');
    else if (this.sortBy.length != 0 && this.searchActivate)
      this.fetch(this.searchBy, this.search, this.pageNo, "&sort=" + this.sortBy);
  }

  previousClick() {
    this.pageNo--;
    if (this.sortBy.length == 0 && !this.searchActivate)
      this.fetch('', '', this.pageNo, '');
    else if (this.sortBy.length != 0 && !this.searchActivate)
      this.fetch('', '', this.pageNo, "&sort=" + this.sortBy);
    else if (this.sortBy.length == 0 && this.searchActivate)
      this.fetch(this.searchBy, this.search, this.pageNo, '');
    else if (this.sortBy.length != 0 && this.searchActivate)
      this.fetch(this.searchBy, this.search, this.pageNo, "&sort=" + this.sortBy);
  }

  fetch(searchBy: string, search: string, pageNo, sortBy: string) {
    this.data = false;
    let searchField = '?';
    if (this.searchActivate = true && searchBy.length != 0 && search.length != 0) {
      searchField = '/' + searchBy + '?' + searchBy + '=' + search + '&';
    }
    this.ticketService.getAllTicketsAdmin(searchField + this.params + pageNo + sortBy).subscribe(
      (resData) => {
        this.ticketData = resData.content;
        this.lastpage = resData.last;
        this.firstpage = resData.first;
        this.data = true;
        if (this.ticketData.length != 0)
          this.tickets = true;
      },
      (error) => {
        console.log(error);
      }
    );
  }

  updateSortModel() {
    this.pageNo = 0;
    if (!this.searchActivate)
      this.fetch('', '', this.pageNo, "&sort=" + this.sortBy);
    else
      this.fetch(this.searchBy, this.search, this.pageNo, "&sort=" + this.sortBy);
  }

  searchTickets() {
    if (this.search.length != 0 && this.searchBy.length != 0) {
      this.searchActivate = true;
      this.sortBy = '';
      this.pageNo = 0;
      this.fetch(this.searchBy, this.search, this.pageNo, '');
    }
    else {
      this.searchActivate = false;
      this.sortBy = '';
      this.pageNo = 0;
      this.search = '';
      this.searchBy = '';
      this.fetch('', '', this.pageNo, '');
    }
  }
}
