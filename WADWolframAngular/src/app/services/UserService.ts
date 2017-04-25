import {UserProjectComponent} from "../entities/UserProjectsComponent";
import {UserMovementsComponent} from "../entities/UserMovementsComponent";
import {UserPersonalData} from "../entities/UserPersonalData";
import{User} from "../entities/User";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs/Observable";
import{Router} from "@angular/router";
import {Http, Headers} from "@angular/http";
import "rxjs/Rx";

@Injectable()
export class UserService{

   private credentials: string;
   //private user:User;
 
    constructor(private http: Http){}
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

     updateUser(id:number, userPersonalData:UserPersonalData){
         let headers = new Headers();
         return this.http.put("https://localhost:8443/api/user/update/"+id,userPersonalData,{headers:headers})
             .map(response => response.json())
            .catch(error => this.handleError(error));
     }

     addUser(user:UserPersonalData){
         return this.http.post("https://localhost:8443/api/user/register/create", user)
            .map(response => response.json())
            .catch(error => this.handleError(error));
     }
     getMovements(){
         return this.http.get("https://localhost:8443/api/user/allMovements")
         .map(response=>response.json())
         .catch(error=>this.handleError(error));
     }
     getPersonalData(){
         return this.http.get("http:((localhost:8443/api/user/personalData")
         .map(response=>response.json())
         .catch(error=>this.handleError(error));
     }
     getUserProjects(){
         return this.http.get("http:((localhost:8443/api/user/userProjects")
         .map(response=>response.json())
         .catch(error=>this.handleError(error));
     }
     getOtherProjects(){
         return this.http.get("http:((localhost:8443/api/user/otherProjects")
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
    
}