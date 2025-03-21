import { TestBed } from '@angular/core/testing';

import { ServeSpringbootService } from './serve-springboot.service';

describe('ServeSpringbootService', () => {
  let service: ServeSpringbootService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ServeSpringbootService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
