import { Component, OnInit } from '@angular/core';
import { Ticket } from 'src/app/models/ticket';
import { TicketService } from 'src/app/services/ticket.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  pageNo: number = 0;
  params: string = `?size=5&page=`;
  ticketData: Ticket[];
  lastpage: boolean;
  firstpage: boolean;
  getData :boolean = false; 
  tickets:boolean = false;
  constructor(private ticketService: TicketService) { }

  ngOnInit(): void {
    this.fetch();
  }
  nextClick() {
    this.pageNo++;
    this.fetch();
  }

  previousClick() {
    this.pageNo--;
    this.fetch();
  }

  fetch() {
    this.getData = false;
    this.ticketService.getAllTicketsUser(this.params+this.pageNo).subscribe(
      (resData) => {
        this.ticketData = resData.content;
        this.lastpage = resData.last;
        this.firstpage = resData.first;
        this.tickets = true;
        if(this.ticketData.length==0)
          this.tickets = false;
        this.getData = true;
      },
      (error) => {
        console.log(error);
      }
    );
  }
}
