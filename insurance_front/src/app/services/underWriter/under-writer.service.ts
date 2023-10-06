import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UnderWriterService {

  writer_url ="http://localhost:9119/writer";
  constructor(private http:HttpClient) { }

  //Get All plans of All Users in which isVerified is num
  public getPlansByIsVerified(num:number){
    return this.http.get(`${this.writer_url}/verifyUserPlan/`+num);
  }

  //Get All Claims of All Users in which status is num
  public getClaimsByStatus(num:number){
    return this.http.get(`${this.writer_url}/statusClaim/`+num);
  }

  //Get UserPlan By OrderId
  public getUserPlan(order_id:number){
    return this.http.get(`${this.writer_url}/userPlanDetail/`+order_id)
  }
  
  //Approve Or Reject User Plan
  public verifyUserPlan(user_plan_object:object){
    return this.http.post(`${this.writer_url}/verifyUserPlan`,user_plan_object);
  }

  //Get Claim By claimId
  public getClaimById(claim_id:number) {
    return this.http.get(`${this.writer_url}/claim/`+claim_id)
  }

   //Approve Or Reject Claim Request
   public verifyClaim(claim:object){
    return this.http.post(`${this.writer_url}/verifyClaim`,claim);
  }
}
