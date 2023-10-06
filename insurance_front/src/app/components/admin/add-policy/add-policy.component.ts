import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { AdminService } from 'src/app/services/admin/admin.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-add-policy',
  templateUrl: './add-policy.component.html',
  styleUrls: ['./add-policy.component.css']
})
export class AddPolicyComponent implements OnInit {

  policy={
    policyName:"",
    policyDetail:"",
  }

  constructor(private _policy:AdminService, private _snack:MatSnackBar,private router:Router) { }

  ngOnInit(): void {
  }
  formSubmit()
    {
      if(this.policy.policyName.trim()==''|| this.policy.policyName==null)
      {
         this._snack.open("Name Required",'',{
           duration:3000
         })
         return;
      }
      console.log(this.policy);
      this._policy.addPolicy(this.policy).subscribe(
        (data:any)=>{
          this.policy.policyName='';
          this.policy.policyDetail='';
          Swal.fire("OK","Policy Added Succesfully","success")
          this.router.navigate(['/admin/policy']);
        }
      )
    }


}
