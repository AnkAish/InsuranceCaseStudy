import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { LoginService } from 'src/app/services/home/login.service';
import { UserServiceService } from 'src/app/services/user/user-service.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  user:any;
  nameEdit:any;
  contactEdit:any;
  name:any;
  contact:any;
  constructor(public loginService:LoginService,
    private userService:UserServiceService,
    private snack:MatSnackBar) { }

  ngOnInit(): void {
    this.nameEdit=false
    this.contactEdit=false
    this.user=this.loginService.getUser();
    // this.value=[this.loginService.getUser()];

  }
  cancelEdit(): void{
    window.location.href='/dashBoard/profile'
  }

  //UPDATE NAME
  editName(): void{
    this.nameEdit=true;
  }
  updateName(){    
    this.userService.updateName(this.name,this.user.id).subscribe(res=>{
      if(res){
        this.loginService.getCurrentUser().subscribe((user1:any)=>{
          this.loginService.setUser(user1)
        })
        this.user=this.loginService.getUser();
      }
      this.snack.open('Name Updated','',{duration: 3000,});
      window.location.href='/dashBoard/profile'
     
    },error=>{
      console.log(error);
      
    })
  }
  //UPDATE CONTACT
  editContact(): void{
    this.contactEdit=true;
  }
  updateContact(){    
    this.userService.updateContact(this.contact,this.user.id).subscribe(res=>{
      if(res){
        this.loginService.getCurrentUser().subscribe((user1:any)=>{
          this.loginService.setUser(user1)
        })
        this.user=this.loginService.getUser();
      }
      this.snack.open('Contact Number Updated','',{duration: 3000,});
      window.location.href='/dashBoard/profile'
      
    },error=>{
      console.log(error);
      
    })
  }
}
