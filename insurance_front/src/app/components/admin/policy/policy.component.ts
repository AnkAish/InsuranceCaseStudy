import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from 'src/app/services/admin/admin.service'; 
import { DialogueService } from 'src/app/services/dialogue.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-policy',
  templateUrl: './policy.component.html',
  styleUrls: ['./policy.component.css']
})
export class PolicyComponent implements OnInit {

  policy_data : any[] | undefined;
  policy_id : number | undefined;
  constructor(private policy : AdminService,
    private dialogue:DialogueService,
    private router:Router) { }

  ngOnInit(): void {
    this.policy.getPolicies().subscribe((result)=>{
      this.policy_data = result
     });
  }

  clickMethod(policyId:number) {
    this.dialogue.openConfirmDialogue("Are You Sure You Want To Delete Policy.")
    .afterClosed().subscribe(res=>{
      if(res){
        this.policy.deletePolicy(policyId).subscribe((data:any)=>{
          Swal.fire("OK","Policy is Deleted","success");
          
      });
      }
      window.location.href='/admin/policy'
    });
  }
}
