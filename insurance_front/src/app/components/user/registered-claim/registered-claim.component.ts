import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/home/login.service';
import { UserServiceService } from 'src/app/services/user/user-service.service';

@Component({
  selector: 'app-registered-claim',
  templateUrl: './registered-claim.component.html',
  styleUrls: ['./registered-claim.component.css']
})
export class RegisteredClaimComponent implements OnInit {

  claim_object:any
  constructor(private login:LoginService,
    private userService:UserServiceService) { }

  ngOnInit(): void {
    this.userService.getClaimOfUser(this.login.getUser().id).subscribe(result=>{
      this.claim_object=result
      console.log(this.claim_object);
      
    })
  }

}
