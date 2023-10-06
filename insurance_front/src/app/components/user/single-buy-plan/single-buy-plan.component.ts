import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { DialogueService } from 'src/app/services/dialogue.service';
import { LoginService } from 'src/app/services/home/login.service';
import { UserServiceService } from 'src/app/services/user/user-service.service';

@Component({
  selector: 'app-single-buy-plan',
  templateUrl: './single-buy-plan.component.html',
  styleUrls: ['./single-buy-plan.component.css']
})
export class SingleBuyPlanComponent implements OnInit {

 //userplan fields
user_plan ={
  orderId:"", startDate:"", endDate:"", amountPaid:0, premiumAmount:"", sumAssured:"",
  duration:"", returnAmt:"", isVerified:"",count:0,
  user:{
    id:"",
  }, plan:{
      planId:"",
    },
    nominee:{
    },
}
//fields
  planId : any ;
  single_Plan: any;
  planName: String | undefined;
  planType: String | undefined;
  planDescription: String | undefined;
  minAge:Number | undefined;
  maxAge:Number | undefined;
  validity:Number | undefined;
  value: (number)[]=[];
  array:any|undefined;
  paymentFrequency:number | undefined;
  policyName:string

  constructor(private singlePlan : UserServiceService,
    private route:ActivatedRoute, 
    private loginService:LoginService, 
    private router:Router,
    private snack:MatSnackBar,
    private dialogue:DialogueService,) { }

  ngOnInit(): void {
    this.planId=this.route.snapshot.paramMap.get('planId');
    this.singlePlan.getSinglePlan(this.planId).subscribe((result)=>{
      this.single_Plan = result;
      this.planName=this.single_Plan.planName;
      this.planType=this.single_Plan.planType;
      this.planDescription=this.single_Plan.planDescription;
      this.paymentFrequency=this.single_Plan.paymentFrequency;
      this.minAge=this.single_Plan.minAge;
      this.maxAge=this.single_Plan.maxAge;
      this.validity=this.single_Plan.planValidity;
      this.policyName=this.single_Plan.policy.policyName;
      console.log(this.single_Plan);
      
      localStorage.setItem('plan',result);
     });
     this.value=[this.loginService.getUser().id,this.planId];
     this.singlePlan.fetchParticulatPlan(this.value).subscribe(
       result=>{
         this.array=result;
         this.user_plan.premiumAmount=this.array.premiumAmount;
         this.user_plan.startDate=this.array.startDate;
         this.user_plan.endDate=this.array.endDate;
         this.user_plan.sumAssured=this.array.sumAssured;
         this.user_plan.duration=this.array.duration; 
         this.user_plan.isVerified=this.array.isVerified;
         this.user_plan.returnAmt=this.array.returnAmt;
         this.user_plan.count=this.array.count;
         this.user_plan.user.id=this.loginService.getUser().id
         this.user_plan.plan.planId=this.planId
         localStorage.setItem("userPlan",JSON.stringify(this.user_plan));
       }
     )
  }

  clickMethod() {
    this.dialogue.openConfirmDialogue("Are You Sure You Want To Buy Plan.")
    .afterClosed().subscribe(res=>{
      if(res){
        if(this.policyName=="Life Insurance")
          this.router.navigate(['/dashBoard/nominee/']);
        else{
          this.singlePlan.addUserPlan(this.user_plan).subscribe(result=>{})
          this.snack.open("Plan Buy Successfully","",{duration:3000,})
          window.location.href="/dashBoard/registeredPlan"
        }
      }
      else
        this.router.navigate(['dashBoard/singlePlan/:'+this.planId]);
    });
  }
}