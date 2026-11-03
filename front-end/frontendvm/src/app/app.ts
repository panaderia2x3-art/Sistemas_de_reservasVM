import { Component, signal } from '@angular/core';
import { CompTecnicos } from './Components/comp-tecnicos/comp-tecnicos';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CompTecnicos],
  styleUrl: './app.scss',
  templateUrl: './app.html',
})
export class App {
  protected readonly title = signal('frontendvm');
}
