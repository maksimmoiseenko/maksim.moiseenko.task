import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Unit} from "../models/Unit";

@Injectable({
  providedIn: 'root'
})
export class SensorService {
  token = localStorage.getItem('token')
  headers = new HttpHeaders({ Authorization: 'Bearer ' + this.token })
  public getSensors(){
    return this.http.get('http://localhost:8080/sensors',{ headers: this.headers });
  }
  public getUnits(){
    return this.http.get('http://localhost:8080/units',{ headers: this.headers });
  }
  public getTypes(){
    return this.http.get('http://localhost:8080/types',{ headers: this.headers });
  }
  public delete(id){
    this.http.post('http://localhost:8080/sensor/delete', id,{ headers: this.headers }).subscribe();
  }
  public save(form){
    this.http.post('http://localhost:8080/sensor/save', form,{ headers: this.headers }).subscribe();
  }
  public update(sensor){
    this.http.post('http://localhost:8080/sensor/update', sensor,{ headers: this.headers }).subscribe();
  }
  public search(form){
    return this.http.get('http://localhost:8080/sensors/search/' + form,{ headers: this.headers });
  }
  constructor(private http: HttpClient) { }

  getById(sensorId: number) {
    return this.http.get('http://localhost:8080/sensor/' + sensorId,{ headers: this.headers });
  }
}
