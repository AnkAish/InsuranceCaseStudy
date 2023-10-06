import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UserServiceService } from 'src/app/services/user/user-service.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-home-policy',
  templateUrl: './home-policy.component.html',
  styleUrls: ['./home-policy.component.css']
})
export class HomePolicyComponent implements OnInit {

  plans:any | undefined;
  policyId: any;
  user_age=0;
  policy=[]
  constructor(private userService : UserServiceService, private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.policyId=this.route.snapshot.paramMap.get('policyId');
    this.userService.getPlans(this.policyId).subscribe((result)=>{
       this.plans = result
     },
     error=>{
       console.log(error);
       
     });
  }
}
