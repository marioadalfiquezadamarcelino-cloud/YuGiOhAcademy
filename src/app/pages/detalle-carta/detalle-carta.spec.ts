import { ComponentFixture, TestBed } from '@angular/core/testing';
import { DetalleCarta } from './detalle-carta';

describe('DetalleCarta', () => {
  let component: DetalleCarta;
  let fixture: ComponentFixture<DetalleCarta>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DetalleCarta],
    }).compileComponents();

    fixture = TestBed.createComponent(DetalleCarta);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
