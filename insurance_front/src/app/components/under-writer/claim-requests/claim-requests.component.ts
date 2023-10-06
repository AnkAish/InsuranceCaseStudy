import { Component, OnInit } from '@angular/core';
import { UnderWriterService } from 'src/app/services/underWriter/under-writer.service';

@Component({
  selector: 'app-claim-requests',
  templateUrl: './claim-requests.component.html',
  styleUrls: ['./claim-requests.component.css']
})
export class ClaimRequestsComponent implements OnInit {


  claim_object:any
  num:number
  constructor(private writer:UnderWriterService) { }

  ngOnInit(): void {
    this.num=1
    this.writer.getClaimsByStatus(this.num).subscribe(result=>{
      console.log(result);
      this.claim_object=result
      
    },error=>{
      console.log(error);
      
    })
  }
}



