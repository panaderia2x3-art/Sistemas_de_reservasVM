import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CompClientes } from './comp-clientes';

describe('CompClientes', () => {
  let component: CompClientes;
  let fixture: ComponentFixture<CompClientes>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CompClientes],
    }).compileComponents();

    fixture = TestBed.createComponent(CompClientes);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
