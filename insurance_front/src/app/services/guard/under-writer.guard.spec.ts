import { TestBed } from '@angular/core/testing';

import { UnderWriterGuard } from './under-writer.guard';

describe('UnderWriterGuard', () => {
  let guard: UnderWriterGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(UnderWriterGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
