import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { AdminTicket } from 'src/app/models/adminTicket';
import { TicketService } from 'src/app/services/ticket.service';

@Component({
  selector: 'app-edit-ticket-admin',
  templateUrl: './edit-ticket-admin.component.html',
  styleUrls: ['./edit-ticket-admin.component.css'],
})
export class EditTicketAdminComponent implements OnInit {
  adminTicketData: AdminTicket = new AdminTicket();
  statuses: string[] = ['in process', 'done'];
  files: File[] = [];
  getData: boolean = false;
  id: string;
  message: string;
  canUpload: boolean = true;
  routeSub: Subscription;
  constructor(private router: ActivatedRoute, private ticketService: TicketService, private route: Router) { }

  ngOnInit(): void {
    this.routeSub = this.router.params.subscribe((params: Params) => {
      this.id = params['id'];
    });
    this.ticketService.getATicket(this.id).subscribe(
      async (data) => {
        this.adminTicketData = data;
        await this.adminTicketData;
        if (this.adminTicketData) {
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
      return;
    }
    let comments = '';
    comments = form.value.comments;
    let status = form.value.status;
    this.ticketService.updateTicketAdmin(status, comments, this.files, this.id)
      .subscribe(
        async (data) => {
          this.adminTicketData = data;
          await this.adminTicketData;
          if (this.adminTicketData) {
            this.getData = true;
            alert('Ticket updated successfully!')
            this.route.navigate(['/admin/dashboard']);
          }
        },
        (error) => {
          alert('Error updating ticket!')
          console.log(error);
        }
      );
  }

  public onFileChanged(event) {
    this.files = event.target.files;
    let maxSize = 0;
    const maxAllowedSize = 2 * 1024 * 1024;
    if (this.files) {
      for (let i = 0; i < this.files.length; i++) {
        maxSize += this.files[i].size;
      }
    }
    if (maxSize > maxAllowedSize) {
      this.canUpload = false;
      alert('Files size larger than 2 MB.');
      return;
    } else {
      this.canUpload = true;
      return;
    }

  }
}
