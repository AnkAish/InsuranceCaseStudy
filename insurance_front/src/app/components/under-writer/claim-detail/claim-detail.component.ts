import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';
import { DialogueService } from 'src/app/services/dialogue.service';
import { UnderWriterService } from 'src/app/services/underWriter/under-writer.service';

@Component({
  selector: 'app-claim-detail',
  templateUrl: './claim-detail.component.html',
  styleUrls: ['./claim-detail.component.css']
})
export class ClaimDetailComponent implements OnInit {

  claim={
    claimId:"",
    claimAmount:"",
    claimStatus:1,
    generationDate:"",
    reason:"",
    user:{
      id:""
    },
    userPlanDetail:{
      orderId:""
    }
  }

  claim_object:any
  claim_id:any
  constructor(private route:ActivatedRoute,
    private under:UnderWriterService,
    private dialogue:DialogueService,
    private snack:MatSnackBar) { }

  ngOnInit(): void {
    this.claim_id=this.route.snapshot.paramMap.get('claimId');
    this.under.getClaimById(this.claim_id).subscribe(result=>{
      this.claim_object=result
      this.claim.claimId=this.claim_object.claimId
      this.claim.claimAmount=this.claim_object.claimAmount
      this.claim.claimStatus=this.claim_object.claimStatus
      this.claim.generationDate=this.claim_object.generationDate
      this.claim.reason=this.claim_object.reason
      this.claim.user.id=this.claim_object.user.id
      this.claim.userPlanDetail.orderId=this.claim_object.userPlanDetail.orderId
    })
  }

  public set2() {
    this.dialogue.openConfirmDialogue("Are You Sure You Want To Approve Claim Request.")
    .afterClosed().subscribe(res=>{
      if(res){
        this.claim.claimStatus=2
        this.under.verifyClaim(this.claim).subscribe(result=>{
        })
        this.snack.open("Claim Approved Successfully","",{duration:3000,})
        window.location.href="/underDashboard/claimReq"
      }
    })
  }

  public set0() {
    this.dialogue.openConfirmDialogue("Are You Sure You Want To Reject Claim Request.")
    .afterClosed().subscribe(res=>{
      if(res){
        this.claim.claimStatus=0
        this.under.verifyClaim(this.claim).subscribe(result=>{
        })
        this.snack.open("Claim Request Rejected","",{duration:3000,})
        window.location.href="/underDashboard/claimReq"
      }
    })
  }

}
