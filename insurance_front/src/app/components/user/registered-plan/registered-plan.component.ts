import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { DialogueService } from 'src/app/services/dialogue.service';
import { LoginService } from 'src/app/services/home/login.service';
import { UserServiceService } from 'src/app/services/user/user-service.service';

@Component({
  selector: 'app-registered-plan',
  templateUrl: './registered-plan.component.html',
  styleUrls: ['./registered-plan.component.css']
})
export class RegisteredPlanComponent implements OnInit {

  user_plan_object:any
  claim:any
  constructor(private userService:UserServiceService,
    private login:LoginService,
    private dialogue:DialogueService,
    private snack:MatSnackBar) { }
    
  ngOnInit(): void {
    this.userService.getUserPlan(this.login.getUser().id).subscribe(result=>{
      this.user_plan_object=result
      console.log(this.user_plan_object);
    },error=>{
      console.log(error);
    }) 
    this.userService.getClaimOfUser(this.login.getUser().id).subscribe((result:any)=>{
      if(result){
        this.claim=result
      }
      console.log(result.userPlanDetail.orderId);
      
    })
  }

  payment(orderId:number){
    this.dialogue.openConfirmDialogue("Are You Sure You Want To Pay Premium.")
    .afterClosed().subscribe(res=>{
      if(res){
        this.userService.payPremium(orderId).subscribe(result=>{})
        this.snack.open("Payment Done Successfully","",{duration:3000,})
        window.location.reload();
      }
    });
  }

  deletePlan(orderId:number){
    this.dialogue.openConfirmDialogue("Are You Sure You Want To Delete Rejected Plan.")
    .afterClosed().subscribe(res=>{
      if(res){
        this.userService.deletePlan(orderId).subscribe(result=>{});
        this.snack.open("Plan Deleted Successfully","",{duration:3000,})
        window.location.reload();
      }
    });
  }

}