import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { DialogueService } from 'src/app/services/dialogue.service';
import { LoginService } from 'src/app/services/home/login.service';
import { UserServiceService } from 'src/app/services/user/user-service.service';

@Component({
  selector: 'app-claim',
  templateUrl: './claim.component.html',
  styleUrls: ['./claim.component.css']
})
export class ClaimComponent implements OnInit {

  claim={
    claimAmount:0,
    claimStatus:1,
    reason:"",
    userPlanDetail:{
      orderId:'',
    },
    user:{
      id:'',
    },
  }
  orderId:any
  constructor(private snack:MatSnackBar,
    private userService:UserServiceService,
    private dialogue:DialogueService,
    private router:Router,
    private route:ActivatedRoute,
    private login:LoginService) { }

  ngOnInit(): void {
    this.orderId=this.route.snapshot.paramMap.get('orderId');
    //Set Order Id In Claim Object
    this.claim.userPlanDetail.orderId=this.orderId
    this.userService.getUserPlanByOrderId(this.orderId).subscribe((result:any)=>{
      //Set Claim Amount In Claim Object
      this.claim.claimAmount=result.sumAssured
    })
    //Set User Id In Claim Object
    this.claim.user.id=this.login.getUser().id
  }

  formSubmit(){
    if(this.claim.reason.trim()==''|| this.claim.reason==null)
    {
       this.snack.open("Reason Is Required",'',{
         duration:3000
       })
       return;
    }
    else{
      this.dialogue.openConfirmDialogue("Are You Sure You Want To Generate Request for Claim?")
    .afterClosed().subscribe(res=>{
      if(res){
        this.userService.requestClaim(this.claim,this.orderId).subscribe(result=>{})
        this.snack.open("Claim Request Generated",'',{duration:3000})
        //this.router.navigate(['dashBoard/registeredPlan'])
        window.location.href='dashBoard/registeredPlan';
      }
      else
      this.router.navigate(['dashBoard/registeredPlan'])
    })
    }
  }

}
