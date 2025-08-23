import FinosuvidhaAccount from './NativeFinosuvidhaAccount';
import type { AccountOpeningResponseProps } from './types';

export function startAccountOpening(
  encToken: string,
  lat: string,
  lng: string
): Promise<AccountOpeningResponseProps> {
  return FinosuvidhaAccount.startAccountOpening(encToken, lat, lng);
}
