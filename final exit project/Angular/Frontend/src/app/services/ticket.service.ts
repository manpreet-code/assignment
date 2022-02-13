import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { Alltickets } from '../models/alltickets';
import { Ticket } from '../models/ticket';
import { TicketRegister } from '../models/ticketRegister';

@Injectable({
  providedIn: 'root',
})
export class TicketService {
  constructor(private http: HttpClient) { }


  newticket(ticketRegister: TicketRegister): Observable<any> {
    let requestType = ticketRegister.requestType;
    let priority = ticketRegister.priority;
    let travelCity = ticketRegister.travelCity;
    let fromLocationCity = ticketRegister.fromLocationCity;
    let travelStartDate = ticketRegister.travelStartDate;
    let travelEndDate = ticketRegister.travelEndDate;
    let passportNumber = ticketRegister.passportNumber;
    let projectName = ticketRegister.projectName;
    let expenseBorneBy = ticketRegister.expenseBorneBy;
    let travelApproverName = ticketRegister.travelApproverName;
    let expectedDurationOfTravel = ticketRegister.expectedDurationOfTravel;
    let upperBound = ticketRegister.upperBound;
    let anyAdditionalDetails = ticketRegister.anyAdditionalDetails;


    return this.http.post<TicketRegister>(environment.apiUrl + '/tickets', {
      requestType,
      priority,
      travelCity,
      fromLocationCity,
      travelStartDate,
      travelEndDate,
      passportNumber,
      projectName,
      expenseBorneBy,
      travelApproverName,
      expectedDurationOfTravel,
      upperBound,
      anyAdditionalDetails,
    });
  }

  updateTicket(ticketRegister: TicketRegister): Observable<any> {
    let id = ticketRegister.id;
    let requestType = ticketRegister.requestType;
    let priority = ticketRegister.priority;
    let travelCity = ticketRegister.travelCity;
    let fromLocationCity = ticketRegister.fromLocationCity;
    let travelStartDate = ticketRegister.travelStartDate;
    let travelEndDate = ticketRegister.travelEndDate;
    let passportNumber = ticketRegister.passportNumber;
    let projectName = ticketRegister.projectName;
    let expenseBorneBy = ticketRegister.expenseBorneBy;
    let travelApproverName = ticketRegister.travelApproverName;
    let expectedDurationOfTravel = ticketRegister.expectedDurationOfTravel;
    let upperBound = ticketRegister.upperBound;
    let anyAdditionalDetails = ticketRegister.anyAdditionalDetails;

    return this.http.put<TicketRegister>(environment.apiUrl + '/tickets', {
      id,
      requestType,
      priority,
      travelCity,
      fromLocationCity,
      travelStartDate,
      travelEndDate,
      passportNumber,
      projectName,
      expenseBorneBy,
      travelApproverName,
      expectedDurationOfTravel,
      upperBound,
      anyAdditionalDetails,
    });
  }

  getAllTicketsUser(query: string): Observable<any> {
    return this.http.get<Alltickets>(environment.apiUrl + '/tickets/user' + query);
  }

  getAllTicketsAdmin(query: string): Observable<any> {
    return this.http.get<Alltickets>(environment.apiUrl + '/tickets/admin' + query);
  }

  getATicket(id: string): Observable<any> {
    return this.http.get<Ticket>(environment.apiUrl + '/tickets/' + id).pipe(
      map((data) => {
        return data;
      })
    );
  }

  updateTicketAdmin(status: string, comments: string, files: File[], ticketid: string): Observable<any> {
    const formData = new FormData();
    if (files) {
      for (let i = 0; i < files.length; i++) {
        formData.append('files', files[i], files[i].name)
      }
    }
    formData.append("ticketId", ticketid);
    formData.append("comment", comments);
    formData.append("status", status);
    return this.http.put<any>(environment.apiUrl + '/tickets/admin', formData, { observe: 'response' });
  }
}
