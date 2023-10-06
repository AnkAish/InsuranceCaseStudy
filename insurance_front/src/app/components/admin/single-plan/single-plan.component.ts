import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AdminService } from 'src/app/services/admin/admin.service';

@Component({
  selector: 'app-single-plan',
  templateUrl: './single-plan.component.html',
  styleUrls: ['./single-plan.component.css']
})
export class SinglePlanComponent implements OnInit {

  planId : any ;
  single_Plan: any;
  planName: String | undefined;
  planType: String | undefined;
  planDescription: String | undefined;
  minAge:Number | undefined;
  maxAge:Number | undefined;
  validity:Number | undefined;
  paymentFrequency:number | undefined;
  constructor(private singlePlan : AdminService,private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.planId=this.route.snapshot.paramMap.get('id');
    console.log(this.planId);
    this.singlePlan.getSinglePlan(this.planId).subscribe((result)=>{
      this.single_Plan = result;
      this.planName=this.single_Plan.planName;
      this.planType=this.single_Plan.planType;
      this.planDescription=this.single_Plan.planDescription;
      this.paymentFrequency=this.single_Plan.paymentFrequency;
      this.minAge=this.single_Plan.minAge;
      this.maxAge=this.single_Plan.maxAge;
      this.validity=this.single_Plan.planValidity;
      console.log(this.single_Plan);
     });
  }


}
