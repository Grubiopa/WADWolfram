import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { Http, Response } from '@angular/http';
import 'rxjs/Rx';
@Injectable()
export class ProjectService {

    constructor(private http: Http) { }


   getProject(id: number){
      let url="https://localhost:8443/api/project/"+(string(id));
      return this.http.get(url).map(response => response.json()).catch(error => Observable.throw('Server error'));
   }
   getProjects(){
      let url="https://localhost:8443/api/projects";
      return this.http.get(url).map(response => response.json().items).catch(error => Observable.throw('Server error'));
   }
   createProject(project: Project){
      let url="https://localhost:8443/api/project";
      return this.http.post(url, project).map(response => response.json()).catch(error => Observable.throw('Server error'));
   }
   donateProject(id: number, donation: Donation){
      let url="https://localhost:8443/api/project/"+(string(id));
      return this.http.put(url, donation).map(response => response.json()).catch(error => Observable.throw('Server error'));
   }
   deleteProject(id: number){
      let url="https://localhost:8443/api/project/"+(string(id));
      return this.http.delete(url).map(response => response.json()).catch(error => Observable.throw('Server error'));
   }
}