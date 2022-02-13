import { ResponseFiles } from './responseFiles';

export class Ticket {
  id: string;
  requestType = '';
  priority = '';
  travelCity = '';
  fromLocationCity = '';
  travelStartDate: Date;
  travelEndDate: Date;
  passportNumber = '';
  projectName = '';
  expenseBorneBy = '';
  travelApproverName: string;
  expectedDurationOfTravel: string;
  upperBound: string;
  anyAdditionalDetails = '';
  comments = '';
  status = '';
  file: ResponseFiles[];
  userName: string;
}
