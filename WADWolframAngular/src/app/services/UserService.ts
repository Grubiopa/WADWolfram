import {UserProjectComponent} from "../entities/UserProjectsComponent";
import {UserMovementsComponent} from "../entities/UserMovementsComponent";
import {UserPersonalData} from "../entities/UserPersonalData";
import {UserUpdate} from "../entities/UserUpdate"
import{User} from "../entities/User";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs/Observable";
import{Router} from "@angular/router";
import {Http,RequestOptions, Headers} from "@angular/http";
import {LoginService} from "./LoginService";
import "rxjs/Rx";

@Injectable()
export class UserService{

   private credentials: string;
   //private user:User;
 
    constructor(private http: Http, private loginService: LoginService){}
     getUser() {
        return this.http.get("https://localhost:8443/api/user/login")
            .map(response => response.json())
            .catch(error => this.handleError(error));
     }

     
     login(username: string, password: string){
         if (username !== "") {

            let headers = new Headers();//Creación de la cabecera que le tenemos que pasar al método para que nos loguee correctamente.
            this.credentials = btoa(username + ':' + password);//Encriptación de las credenciales del usuario.
            headers.append('Authorization', 'Basic ' + this.credentials);//Añadimos  a la cabecera las credenciales.
            return this.http.get("https://localhost:8443/api/user/login", { headers: headers })
                .map(response => {
                    localStorage.setItem("user", response.json());
                    return response.json();
                })
                .catch(error => this.handleError(error))
        } else {

            return Observable.throw("Server error (401): Introduzca correctamente sus datos de usuario.");

        }
     }

     updateUser(id:number, userPersonalData:UserUpdate){
         const headers = new Headers({
            'X-Requested-With': 'XMLHttpRequest'
        });

        const options = new RequestOptions({ withCredentials: true, headers });
         return this.http.put("https://localhost:8443/api/user/"+id,userPersonalData,options)
             .map(response => response.json())
            .catch(error => this.handleError(error));
     }

     addUser(user:UserPersonalData){
         return this.http.post("https://localhost:8443/api/user/", user)
            .map(response => response.json())
            .catch(error => this.handleError(error));
     }
     getMovements(){
         const headers = new Headers({
            'X-Requested-With': 'XMLHttpRequest'
        });

        const options = new RequestOptions({ withCredentials: true, headers });
         return this.http.get("https://localhost:8443/api/user/allMovements", options)
         .map(response=>response.json())
         .catch(error=>this.handleError(error));
     }
     getPersonalData(){
         return this.loginService.getUser();
     }
     getUserProjects(){
          const headers = new Headers({
            'X-Requested-With': 'XMLHttpRequest'
        });

        const options = new RequestOptions({ withCredentials: true, headers });
         return this.http.get("https://localhost:8443/api/user/userProjects", options)
         .map(response=>response.json())
         .catch(error=>this.handleError(error));
     }
     getOtherProjects(){
          const headers = new Headers({
            'X-Requested-With': 'XMLHttpRequest'
        });

        const options = new RequestOptions({ withCredentials: true, headers });
         return this.http.get("https://localhost:8443/api/user/otherProjects",options)
         .map(response=>response.json())
         .catch(error=>this.handleError(error));
     }
     private handleError(error: any) {
        console.error(error);
        switch (error.status) {
            case 409:
                return Observable.throw("Server error (" + error.status + "): El nombre de usuario ya esta en uso");
            case 404:
                return Observable.throw("Server error (" + error.status + "): Ha ocurrido algun error vuelva a intentarlo");
            case 401:
                return Observable.throw("Server error (" + error.status + "): No esta autorizado para realizar esa acción.");
            case 406:
                return Observable.throw("Server error (" + error.status + "): Rellene los campos correctamente 'Provincia' o 'Categoría' correctamente");
        }

    }

    getDonMovements(){
        return this.http.get("https://localhost:8443/api/admin/donation").map(response=>response.json()).catch(error=>this.handleError(error))
    }
    
}