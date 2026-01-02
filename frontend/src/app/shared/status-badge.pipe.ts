import { Pipe, PipeTransform } from '@angular/core';
import { EstadoOrden } from './models';

@Pipe({
  name: 'statusBadge'
})
export class StatusBadgePipe implements PipeTransform {
  transform(value: EstadoOrden): string {
    switch (value) {
      case 'TOMADA':
        return 'bg-warning text-dark';
      case 'RECIBIDA_DESPACHADOR':
        return 'bg-info text-dark';
      case 'DESPACHADA':
        return 'bg-success';
      default:
        return 'bg-secondary';
    }
  }
}
