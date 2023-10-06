import { TestBed } from '@angular/core/testing';

import { UnderWriterService } from './under-writer.service';

describe('UnderWriterService', () => {
  let service: UnderWriterService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UnderWriterService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
