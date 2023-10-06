import { Component, OnInit } from '@angular/core';
import { FormGroup,FormControl,FormBuilder,NgForm, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { LoginService } from 'src/app/services/home/login.service';
import { UserServiceService } from 'src/app/services/user/user-service.service';


@Component({
  selector: 'app-nominee',
  templateUrl: './nominee.component.html',
  styleUrls: ['./nominee.component.css']
})
export class NomineeComponent implements OnInit {

  addnominee = new FormGroup({
      
    'name': new FormControl('', Validators.required),
    'email': new FormControl(null, [Validators.required, Validators.email]),
    'contactNo': new FormControl(null,Validators.compose([Validators.required, Validators.maxLength(10),Validators.minLength(10)])),
    'gender': new FormControl('', Validators.required),
    'relation': new FormControl('', Validators.required),
    'dob': new FormControl('', Validators.required),
    'address': new FormControl('', Validators.required),
  })
  
  nominee={
    name:"", email:"", address:"", gender:"", dob:"", contactNo:0, relation:"", 
    userPlanDetail:{
      orderId:""
    }
  }

  orderId:any
  user_plan:any
  n:any
  constructor( private userService:UserServiceService,
    private snack:MatSnackBar,
    private router:Router) { }

  ngOnInit(): void {
    this.n=localStorage.getItem('userPlan');
    this.user_plan=JSON.parse(this.n)
  }

  dataSubmit(){
    this.userService.addUserPlan(this.user_plan).subscribe((result:any)=>{
      if(result){
        this.nominee.userPlanDetail.orderId=result.orderId
        this.userService.addNominee(this.nominee).subscribe(result1=>{
          if(result1){
            this.snack.open("Plan Buy Successfully","",{duration:5000,})
            this.router.navigate(['dashBoard/registeredPlan']);
          }
        })
      }
    },error=>{
      console.log(error);
      
    })
  }

}
