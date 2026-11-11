import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CompActividad } from './comp-actividad';

describe('CompActividad', () => {
  let component: CompActividad;
  let fixture: ComponentFixture<CompActividad>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CompActividad],
    }).compileComponents();

    fixture = TestBed.createComponent(CompActividad);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
