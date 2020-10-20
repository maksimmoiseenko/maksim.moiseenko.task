import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class SensorService {
  baseUrl = 'http://localhost:8080/';
  token = localStorage.getItem('token')
  headers = new HttpHeaders({ Authorization: 'Bearer ' + this.token })
  back(){
    this.router.navigate(['/sensors']);
  }
  public getSensors(){
    return this.http.get(this.baseUrl + 'sensors', { headers: this.headers });
  }
  public getUnits(){
    return this.http.get(this.baseUrl + 'units', { headers: this.headers });
  }
  public getTypes(){
    return this.http.get(this.baseUrl + 'types', { headers: this.headers });
  }
  public delete(id){
    this.http.post(this.baseUrl + 'sensor/delete', id, { headers: this.headers }).subscribe();
  }
  public save(form){
    this.http.post(this.baseUrl + 'sensor/save', form, { headers: this.headers }).subscribe(() =>{
this.back();
    });
  }
  public update(sensor){
    this.http.post(this.baseUrl + 'sensor/update', sensor, { headers: this.headers }).subscribe(()=>
    {
      this.back();
    });
  }
  public search(form){
    return this.http.get(this.baseUrl + 'sensors/search/' + form, { headers: this.headers });
  }
  constructor(private http: HttpClient,
              private router: Router) { }

  getById(sensorId: number) {
    return this.http.get(this.baseUrl + 'sensor/' + sensorId, { headers: this.headers });
  }
}
