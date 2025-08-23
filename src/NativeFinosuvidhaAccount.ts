import type { TurboModule } from 'react-native';
import { TurboModuleRegistry } from 'react-native';
import type { AccountOpeningResponseProps } from './types';

export interface Spec extends TurboModule {
  startAccountOpening(encToken: string, lat: string, lng: string): Promise<AccountOpeningResponseProps>;
}

export default TurboModuleRegistry.getEnforcing<Spec>('FinosuvidhaAccount');
