import { Injectable } from '@angular/core';
import { Response } from '@angular/http';
import { New } from '../Class/New';
import { Observable } from 'rxjs/Observable';
import { Http, RequestOptions, Headers } from '@angular/http';
import 'rxjs/Rx';
@Injectable()
export class NewService {

    private news: New[]=[];
    constructor(private http: Http) { }

   getNew(id: number){
      let url="https://localhost:8443/api/new/"+(id);
      return this.http.get(url).map(response => response.json()).catch(error => Observable.throw('Server error'));
   }
   getNews(){
       const headers = new Headers({
            'X-Requested-With': 'XMLHttpRequest'
        });

        const options = new RequestOptions({ withCredentials: true, headers });
      let url="https://localhost:8443/api/news";
      return this.http.get(url).map(response => response.json(), options).catch(error => Observable.throw('Server error'));
   }
  /* createNew(new: New){
      let url="https://localhost:8443/api/new";
      return this.http.post(url, new).map(response => response.json()).catch(error => Observable.throw('Server error'));
   }
   commentNew(id: number, comment: Comment){
      let url="https://localhost:8443/api/new/"+(string(id));
      return this.http.put(url, comment).map(response => response.json()).catch(error => Observable.throw('Server error'));
   }
   deleteNew(id: number){
      let url="https://localhost:8443/api/new/"+(string(id));
      return this.http.delete(url).map(response => response.json()).catch(error => Observable.throw('Server error'));
   }  */
}