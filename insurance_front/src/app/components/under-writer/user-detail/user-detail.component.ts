import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { DialogueService } from 'src/app/services/dialogue.service';
import { UnderWriterService } from 'src/app/services/underWriter/under-writer.service';

@Component({
  selector: 'app-user-detail',
  templateUrl: './user-detail.component.html',
  styleUrls: ['./user-detail.component.css']
})
export class UserDetailComponent implements OnInit {

  user_plan ={
    orderId:"",
    startDate:"",
    endDate:"",
    amountPaid:0,
    premiumAmount:"",
    sumAssured:"",
    duration:"",
    returnAmt:"",
    isVerified:1,
    user:{
      id:"",
    },
    plan:{
      planId:"",
    }
  }

  user_plan_object:any
  temp : any
  constructor(private writer:UnderWriterService,
    private route:ActivatedRoute,
    private verify_user_plan:UnderWriterService,
    private snack:MatSnackBar,
    private dialogue:DialogueService,
    private router:Router) { }

  ngOnInit(): void {
    this.temp=this.route.snapshot.paramMap.get('orderId');
    this.writer.getUserPlan(this.temp).subscribe(result=>{
      console.log(result);
      this.user_plan_object=result
      this.user_plan.orderId=this.user_plan_object.orderId
      this.user_plan.startDate=this.user_plan_object.startDate
      this.user_plan.endDate=this.user_plan_object.endDate
      this.user_plan.amountPaid=this.user_plan_object.amountPaid
      this.user_plan.premiumAmount=this.user_plan_object.premiumAmount
      this.user_plan.sumAssured=this.user_plan_object.sumAssured
      this.user_plan.duration=this.user_plan_object.duration
      this.user_plan.returnAmt=this.user_plan_object.returnAmt
      this.user_plan.user.id=this.user_plan_object.user.id
      this.user_plan.plan.planId=this.user_plan_object.plan.planId
    },error=>{
      console.log(error);
    })
  }

  public set2() {
    this.dialogue.openConfirmDialogue("Are You Sure You Want To Approve User.")
    .afterClosed().subscribe(res=>{
      if(res){
        this.user_plan.isVerified=2
        this.verify_user_plan.verifyUserPlan(this.user_plan).subscribe(result=>{
        })
        this.snack.open("User Approved Successfully","",{duration:3000,})
        window.location.href="/underDashboard/approveReject"
      }
    })
  }

  public set0() {
    this.dialogue.openConfirmDialogue("Are You Sure You Want To Reject User.")
    .afterClosed().subscribe(res=>{
      if(res){
        this.user_plan.isVerified=0
        this.verify_user_plan.verifyUserPlan(this.user_plan).subscribe(result=>{
        })
        this.snack.open("User Rejected Successfully","",{duration:3000,})
        window.location.href="/underDashboard/approveReject"
      }
    })
  }
}
