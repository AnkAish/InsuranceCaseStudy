import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';
import { DialogueService } from 'src/app/services/dialogue.service';
import { LoginService } from 'src/app/services/home/login.service';
import { UserServiceService } from 'src/app/services/user/user-service.service';

@Component({
  selector: 'app-admin-user-plan',
  templateUrl: './admin-user-plan.component.html',
  styleUrls: ['./admin-user-plan.component.css']
})
export class AdminUserPlanComponent implements OnInit {

  user_plan_object:any
  user_id:any
  constructor(private userService:UserServiceService,
    private route:ActivatedRoute,) { }

  ngOnInit(): void {
    this.user_id=this.route.snapshot.paramMap.get('id');
    this.userService.getUserPlan(this.user_id).subscribe(result=>{
      this.user_plan_object=result
    },error=>{
      console.log(error);
    }) 
  }
}
