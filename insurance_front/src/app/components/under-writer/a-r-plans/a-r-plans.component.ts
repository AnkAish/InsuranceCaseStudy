import { Component, OnInit } from '@angular/core';
import { UnderWriterService } from 'src/app/services/underWriter/under-writer.service';

@Component({
  selector: 'app-a-r-plans',
  templateUrl: './a-r-plans.component.html',
  styleUrls: ['./a-r-plans.component.css']
})
export class ARPlansComponent implements OnInit {

  user_plan_object:any
  num:number
  constructor(private writer:UnderWriterService) { }

  ngOnInit(): void {
    this.num=1
    this.writer.getPlansByIsVerified(this.num).subscribe(result=>{
      console.log(result);
      this.user_plan_object=result
      
    },error=>{
      console.log(error);
      
    })
  }

}
