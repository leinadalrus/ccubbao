import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { MHyperlinkage } from '../../models/facades/mhyperlinkage';

const baseUrl = 'http://localhost:8080/api/qbao';

@Injectable({
  providedIn: 'root',
})
export class ServeSpringbootService {
  constructor(private httpClient: HttpClient) {}

  getAll(): Observable<MHyperlinkage[]> {
    return this.httpClient.get<MHyperlinkage[]>(baseUrl);
  }

  getId(id: any): Observable<MHyperlinkage> {
    return this.httpClient.get<MHyperlinkage>(`${baseUrl}/${id}`);
  }

  create(data: any): Observable<any> {
    return this.httpClient.post(baseUrl, data);
  }

  update(id: any, data: any): Observable<any> {
    return this.httpClient.put(`${baseUrl}/${id}`, data);
  }

  delete(id: any): Observable<any> {
    return this.httpClient.delete(`${baseUrl}/${id}`);
  }
}
