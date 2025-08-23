import FinosuvidhaAccount from './NativeFinosuvidhaAccount';
import type { StartAccountResponseProps } from './types';

export function startAccount(
  encToken: string,
  lat: string,
  lng: string
): Promise<StartAccountResponseProps> {
  return FinosuvidhaAccount.startAccount(encToken, lat, lng);
}
