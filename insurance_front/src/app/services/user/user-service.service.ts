import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  home_url ="http://localhost:9119/home";
  user_url="http://localhost:9119/user";
  admin_url="http://localhost:9119/admin";
  constructor(private http:HttpClient) { }
  //Get All Policies
  public getPolicies():Observable<any>{
    return this.http.get(`${this.home_url}/policy`);
  }

  //Get All Plans
  public getPlans(policyId:number):Observable<any>{
    return this.http.get(`${this.home_url}/getPlan/`+policyId);
  }

  //Get Single Plan
  public getSinglePlan(planId:any):Observable<any>{
    console.log(planId);
    return this.http.get(`${this.home_url}/plan/`+planId);

  }

  //Fetch Particular UserPlan Detail
  public fetchParticulatPlan(v: number[]){
    return this.http.get(`${this.user_url}/showPlans/`+v);
  }

  //Set User Plan in localStorage
  public setUserPlan(arr:any){
    localStorage.setItem("userPlan",arr);
  }

  //Get All User Plans of particular user by userId
  public getUserPlan(user_id:number){
    return this.http.get(`${this.user_url}/userPlanDetail1/`+user_id)
  }

  //Get All User Plans of particular user by userId
  public getUserPlanByOrderId(orderId:number){
    return this.http.get(`${this.user_url}/userPlanDetail/`+orderId)
  }

  //Add UserPlan
  public addUserPlan(user_plan_object:object){
    return this.http.post(`${this.user_url}/userPlanDetail`,user_plan_object);
  }

  //Pay Premium
  public payPremium(orderId:number) {
    return this.http.put(`${this.user_url}/updateCount/`+orderId,null);
  }

  //Delete Rejected Plan
  public deletePlan(orderId:number) {
    return this.http.delete(`${this.user_url}/userPlanDetail/`+orderId);
  }

  //Add Nominee For Particular UserPlan
  public addNominee(nominee:object) {
    return this.http.post(`${this.user_url}/nominee/`,nominee);
  }

  //Generate Claim
  public requestClaim(claim:object,orderId:number) {
    return this.http.post(`${this.user_url}/claim/`+orderId,claim);
  }

  //Get All Claims of Particular User
  public getClaimOfUser(id:number) {
    return this.http.get(`${this.user_url}/claim/`+id);
  }

  //Update User Profile
  public updateProfile(id:number,user:any) {
    return this.http.put(`${this.user_url}/`+id,user);
  }

  //Find Nominee by OrderId
  public findNominee(orderId:number) {
    return this.http.get(`${this.user_url}/getNominee/`+orderId);
  }

  //Update User's Name
  public updateName(name:any,id:number) {
    return this.http.put(`${this.user_url}/updateName/`+id,name);
  }

  //Update User's Contact
  public updateContact(contact:any,id:number) {
    return this.http.put(`${this.user_url}/updateContact/`+id,contact);
  }

  //Update User's Password
  public updatePassword(password:string,id:number) {
    return this.http.put(`${this.user_url}/updatePassword/`+id,password);
  }
}
