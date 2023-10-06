import { Component, OnInit } from '@angular/core';
import { FormGroup,FormControl,FormBuilder,NgForm, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { SignUpService } from 'src/app/services/home/sign-up.service';
import Swal from 'sweetalert2';



@Component({
  selector: 'app-customersignup',
  templateUrl: './customersignup.component.html',
  styleUrls: ['./customersignup.component.css']
})

export class CustomersignupComponent implements OnInit {

  hide = true;
  maxDate = new Date();

  customerSignupForm = new FormGroup({
      
    'name': new FormControl('', Validators.required),
    'email': new FormControl(null, [Validators.required, Validators.email]),
    'contactNo': new FormControl(null,Validators.compose([Validators.required, Validators.pattern("[0-9]{10}")])),
    'dob': new FormControl('', Validators.required),
    'adharNo': new FormControl(null,Validators.compose([Validators.required, Validators.pattern("[0-9]{12}")])),
    'gender': new FormControl('', Validators.required),
    'isSmoker': new FormControl('', Validators.required),
    'isAlcoholer': new FormControl('', Validators.required),
    'password': new FormControl(null, [Validators.required, Validators.pattern('(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&].{8,}')]),
  })
  dataSubmit(){
   this.user.saveUser(this.customerSignupForm.value ).subscribe((result)=>{
    Swal.fire("Success","You're Registered Succesfully","success")
    this.router.navigate(['login']);
   },
   error=>{
    Swal.fire("Error","Server Error","error")
    this.router.navigate(['signUp']);
   });
  }

  constructor( private user:SignUpService ,private router:Router) { }

  ngOnInit(): void {

  }

}
