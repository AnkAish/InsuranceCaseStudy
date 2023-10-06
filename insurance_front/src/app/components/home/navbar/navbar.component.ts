import { DOCUMENT } from '@angular/common';
import { Component, Inject, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from 'src/app/services/admin/admin.service';
import { LoginService } from 'src/app/services/home/login.service'; 

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  public loggedIn=false;
  constructor(private route:Router,
    public loginService:LoginService,
    private adminService:AdminService,
    private router:Router) { }

  policyData:any;
  ngOnInit(): void {
   this.loggedIn= this.loginService.isLoggedIn()
   this.policyData=this.adminService.getPolicies().subscribe(data=>{
    this.policyData=data
  })
  }
  logoutUser(){
    this.loginService.logOut();
    location.reload()
  }
  red(policyId:number){
   //this.router.navigate(["/homePolicy",policyId]);
   window.location.href="[/homePolicy,policyId]"
  }
}
