import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  home_url ="http://localhost:9119/home";
  admin_url="http://localhost:9119/admin";
  constructor(private http:HttpClient) { }

  //Get All Policies
  public getPolicies():Observable<any>{
    return this.http.get(`${this.home_url}/policy`);
  }

  //Get All Plans
  public getPlans():Observable<any>{
    return this.http.get(`${this.home_url}/plan`);
  }

  //Delete Policy
  public deletePolicy(policyId:number){
    return this.http.delete(`${this.admin_url}/policy/`+policyId)
  }

  //Delete Plan
  public deletePlan(planId:number){
    return this.http.delete(`${this.admin_url}/plan/`+planId)
  }

  //Add Policy
  public addPolicy(policy:any):Observable<any>{
    return this.http.post(`${this.admin_url}/policy`,policy);
  }

  public addPlan(plan:any):Observable<any>{
    return this.http.post(`${this.admin_url}/plan`,plan)
   }

    //Get All users
  public getUsers():Observable<any>{
    return this.http.get(`${this.admin_url}/user`);
  }

  //Get Single Plan
  public getSinglePlan(planId:any):Observable<any>{
    console.log(planId);
    return this.http.get(`${this.admin_url}/plan/`+planId);

  }
}
