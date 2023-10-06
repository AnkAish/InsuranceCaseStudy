import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UserServiceService } from 'src/app/services/user/user-service.service';

@Component({
  selector: 'app-nominee-detail',
  templateUrl: './nominee-detail.component.html',
  styleUrls: ['./nominee-detail.component.css']
})
export class NomineeDetailComponent implements OnInit {

  orderId:number
  nominee_object:any
  constructor(private userService:UserServiceService,
    private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.orderId=Number(this.route.snapshot.paramMap.get('orderId'));
    this.userService.findNominee(this.orderId).subscribe(res=>{
      if(res){
        this.nominee_object=res
      }
    })
  }

}
