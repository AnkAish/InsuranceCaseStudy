import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { LoginService } from 'src/app/services/home/login.service';
import { UserServiceService } from 'src/app/services/user/user-service.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-buy-plan',
  templateUrl: './buy-plan.component.html',
  styleUrls: ['./buy-plan.component.css']
})
export class BuyPlanComponent implements OnInit {

  plans:any | undefined;
  policyId: any;
  user_age=0;
  policy=[]
  constructor(private userService : UserServiceService, private loginService:LoginService,private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.policyId=this.route.snapshot.paramMap.get('policyId');
    this.userService.getPlans(this.policyId).subscribe((result)=>{
       console.log(result);
       localStorage.setItem('plans',result);
       this.plans = result
     },
     error=>{
       console.log(error);    
     });
    this.user_age=this.loginService.getUser().age
    console.log(this.user_age);
    
  }
}
