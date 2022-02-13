import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Subscription } from 'rxjs';
import { Ticket } from 'src/app/models/ticket';
import { TicketService } from 'src/app/services/ticket.service';

@Component({
  selector: 'app-viewTicket',
  templateUrl: './viewTicket.component.html',
  styleUrls: ['./viewTicket.component.css'],
})
export class ViewTicketComponent implements OnInit {
  id: string;
  routeSub: Subscription;
  userTicketData: Ticket;
  getData = false;
  constructor(
    private router: ActivatedRoute,
    private ticketService: TicketService
  ) { }

  ngOnInit(): void {
    this.routeSub = this.router.params.subscribe((params: Params) => {
      console.log('Hello from edit ticket', params['id']);
      this.id = params['id'];
    });
    this.ticketService.getATicket(this.id).subscribe(
      async (data) => {
        this.userTicketData = data;
        console.log(this.userTicketData);
        await this.userTicketData;
        if (this.userTicketData) {
          this.getData = true;
        }
      },
      (error) => {
        console.log(error);
      }
    );
  }
  onPrint() {
    window.print();
  }
}
