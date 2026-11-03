import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CompTecnicos } from './comp-tecnicos';

describe('CompTecnicos', () => {
  let component: CompTecnicos;
  let fixture: ComponentFixture<CompTecnicos>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CompTecnicos],
    }).compileComponents();

    fixture = TestBed.createComponent(CompTecnicos);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
