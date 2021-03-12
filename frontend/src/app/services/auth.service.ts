import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from 'rxjs';
import {User} from '../models/user.model';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import {CookieService} from 'ngx-cookie-service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private currentUserSubject: BehaviorSubject<User>;
  public authenticatedUser$: Observable<User>;

  constructor(private http: HttpClient,
              private cookieService: CookieService,
              private router: Router
  ) {
    this.currentUserSubject = new BehaviorSubject<User>(null);
    this.authenticatedUser$ = this.currentUserSubject.asObservable();
  }

  public getCurrentUser(): User {
    if (!this.currentUserSubject.getValue()) {
      const currentUser = this.cookieService.get('currentUser');
      if (!currentUser) {
        this.currentUserSubject.next(null);
        return;
      }
      const user: User = JSON.parse(currentUser);
      this.currentUserSubject.next(user);
      return user;
    }
    return this.currentUserSubject.getValue();
  }
}

