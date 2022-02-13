import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { TicketRegister } from 'src/app/models/ticketRegister';
import { TicketService } from 'src/app/services/ticket.service';

@Component({
  selector: 'app-new-ticket',
  templateUrl: './new-ticket.component.html',
  styleUrls: ['./new-ticket.component.css'],
})
export class NewTicketComponent implements OnInit {
  userTicketData: TicketRegister = new TicketRegister();
  expense: string[] = ['NAGARRO', 'CLIENT'];
  requestType: string[] = ['TRAVEL_TICKETS', 'HOTEL_STAY', 'VISA', 'WORK_PERMIT'];
  priority: string[] = ['A_IMMEDIATE', 'B_URGENT', 'C_NORMAL'];
  isNew = true;
  submitted = false;
  getData = false;

  constructor(
    private ticketService: TicketService,
    private router: Router,
  ) { }
  ngOnInit(): void { }
  onSubmit(form: NgForm) {

    if (!form.valid) {
      return;
    }

    this.submitted = true;
    if (this.isNew) {
      this.isNew = false;
      this.ticketService.newticket(this.userTicketData).subscribe(
        async (data) => {
          this.userTicketData = data;
          await this.userTicketData;
          if (this.userTicketData) {
            this.getData = true;
          }
        },
        (error) => {
          console.log(error);
        }
      );
    } else {
      this.ticketService.updateTicket(this.userTicketData).subscribe(
        async (data) => {
          this.userTicketData = data;
          await this.userTicketData;
          if (this.userTicketData) {
            this.getData = true;
          }
        },
        (error) => {
          alert("Error generating ticket! Please fill all fields.");
          console.log(error);
        }
      );
    }
    form.reset();
  }

  onPrint() {
    window.print();
  }

  editData() {
    this.submitted = false;
    this.getData = false;
  }
  cancel(){
    this.submitted = true;
    this.getData = true;
  }
}

