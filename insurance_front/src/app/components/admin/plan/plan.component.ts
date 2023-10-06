import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/services/admin/admin.service'; 
import { DialogueService } from 'src/app/services/dialogue.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-plan',
  templateUrl: './plan.component.html',
  styleUrls: ['./plan.component.css']
})
export class PlanComponent implements OnInit {

  policy_data : any[] | undefined;
  plans : any[] | undefined;
  policy_id : number | undefined;
  constructor(private policy : AdminService,
    private dialogue:DialogueService) { }

  ngOnInit(): void {
    this.policy.getPolicies().subscribe((result)=>{
      this.policy_data = result
     });
     this.policy.getPlans().subscribe((result)=>{
       console.log(result);
      this.plans = result
     });
  }

  deletePlan(planId:number) {
    this.dialogue.openConfirmDialogue("Are You Sure You Want To Delete Plan.")
    .afterClosed().subscribe(res=>{
      if(res){
        this.policy.deletePlan(planId).subscribe(res=>{})
        Swal.fire("OK","Plan is Deleted","success");  
      }
      window.location.href='/admin/plan'
    });
  }
}
