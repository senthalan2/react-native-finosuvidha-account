import type { TurboModule } from 'react-native';
import { TurboModuleRegistry } from 'react-native';
import type { StartAccountResponseProps } from './types';

export interface Spec extends TurboModule {
  startAccount(encToken: string, lat: string, lng: string): Promise<StartAccountResponseProps>;
}

export default TurboModuleRegistry.getEnforcing<Spec>('FinosuvidhaAccount');
