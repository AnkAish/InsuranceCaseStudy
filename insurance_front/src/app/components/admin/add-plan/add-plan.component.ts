import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { AdminService } from 'src/app/services/admin/admin.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-add-plan',
  templateUrl: './add-plan.component.html',
  styleUrls: ['./add-plan.component.css']
})
export class AddPlanComponent implements OnInit {

  policy_data : any[] | undefined;

  plan = {
    planName:"",
    planType:"",
    minAge:"",
    maxAge:"",
    planValidity:"",
    planDescription:"",
    paymentFrequency:"",
    baseValue:"",
    returnYears:"",
    policy:{
      policyId:'',
    },
  }
  constructor(private policy : AdminService, private _snack:MatSnackBar, private add_plan:AdminService,private router:Router) { }

  ngOnInit(): void {
    this.policy.getPolicies().subscribe((result:any)=>{
      this.policy_data = result
     });
  }

  addPlan(){
    if(this.addPlan.name==''||this.addPlan.name==null){
      this._snack.open("Plan Name Required !",'',{
        duration:3000,
      });
      return;
    }
    this.add_plan.addPlan(this.plan).subscribe(
      (data)=>{
        Swal.fire('Success','Plan is added');
        this.router.navigate(['admin/plan']);
      }
    )
  }
  

}
