import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Router} from '@angular/router';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class SensorService {
  baseUrl = environment.apiUrl;
  token = localStorage.getItem('token');
  // headers = new HttpHeaders({ Authorization: 'Bearer ' + this.token });

  back(){
    this.router.navigate(['/sensors']);
  }
  public getSensors(){
    return this.http.get(this.baseUrl + 'sensors'/*,{ headers: this.headers }*/);
  }
  public getUnits(){
    return this.http.get(this.baseUrl + 'units');
  }
  public getTypes(){
    return this.http.get(this.baseUrl + 'types');
  }
  public delete(id){
    this.http.delete(this.baseUrl + 'sensor/delete', id).subscribe();
  }
  public save(form){
    this.http.post(this.baseUrl + 'sensor/save', form).subscribe(() =>{
this.back();
    });
  }
  public update(sensor){
    this.http.post(this.baseUrl + 'sensor/update', sensor).subscribe(()=>
    {
      this.back();
    });
  }
  public search(form){
    return this.http.get(this.baseUrl + 'sensors/search/' + form);
  }
  constructor(private http: HttpClient,
              private router: Router) { }

  getById(sensorId: number) {
    return this.http.get(this.baseUrl + 'sensor/' + sensorId /*, { headers: this.headers }*/);
  }
}
