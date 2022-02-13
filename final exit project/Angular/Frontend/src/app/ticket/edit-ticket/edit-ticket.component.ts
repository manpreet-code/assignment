import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { Ticket } from 'src/app/models/ticket';
import { TicketRegister } from 'src/app/models/ticketRegister';
import { TicketService } from 'src/app/services/ticket.service';

@Component({
  selector: 'app-edit-ticket',
  templateUrl: './edit-ticket.component.html',
  styleUrls: ['./edit-ticket.component.css'],
})
export class EditTicketComponent implements OnInit {
  routeSub: Subscription;
  id: string;
  ticketData: Ticket = new Ticket();
  userTicketData: TicketRegister = new TicketRegister();
  getData = false;
  expense: string[] = ['NAGARRO', 'CLIENT'];
  requestType: string[] = ['TRAVEL_TICKETS', 'HOTEL_STAY', 'VISA', 'WORK_PERMIT'];
  priority: string[] = ['A_IMMEDIATE', 'B_URGENT', 'C_NORMAL'];

  constructor(
    private router: ActivatedRoute,
    private ticketService: TicketService,
    private navigate: Router
  ) { }

  ngOnInit(): void {
    this.routeSub = this.router.params.subscribe((params: Params) => {
      this.id = params['id'];
    });
    this.ticketService.getATicket(this.id).subscribe(
      async (data) => {
        this.ticketData = data;
        await this.ticketData;
        this.userTicketData.id = this.ticketData.id;
        this.userTicketData.requestType = this.ticketData.requestType;
        this.userTicketData.priority = this.ticketData.priority;
        this.userTicketData.travelCity = this.ticketData.travelCity;
        this.userTicketData.fromLocationCity = this.ticketData.fromLocationCity;
        this.userTicketData.travelStartDate = this.ticketData.travelStartDate;
        this.userTicketData.travelEndDate = this.ticketData.travelEndDate;
        this.userTicketData.passportNumber = this.ticketData.passportNumber;
        this.userTicketData.projectName = this.ticketData.projectName;
        this.userTicketData.expenseBorneBy = this.ticketData.expenseBorneBy;
        this.userTicketData.travelApproverName = this.ticketData.travelApproverName;
        this.userTicketData.fromLocationCity = this.ticketData.fromLocationCity;
        this.userTicketData.expectedDurationOfTravel = this.ticketData.expectedDurationOfTravel;
        this.userTicketData.upperBound = this.ticketData.upperBound;
        this.userTicketData.anyAdditionalDetails = this.ticketData.anyAdditionalDetails;

        if (this.ticketData) {
          this.getData = true;
        }
      },
      (error) => {
        console.log(error);
      }
    );
  }

  onSubmit(form: NgForm) {
    if (!form.valid) {
      return null;
    }
    this.ticketService.updateTicket(this.userTicketData).subscribe(
      async (data) => {
        this.userTicketData = data;
        await this.userTicketData;
        if (this.userTicketData) {
          this.getData = true;
          alert("Ticket edited!");
          this.navigate.navigate(["dashboard"])
        }
      },
      (error) => {
        alert("Error editing ticket details!");
        console.log(error);
      }
    );
    form.reset();
  }
}
