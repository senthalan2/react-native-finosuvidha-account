declare module 'react-native-finosuvidha-account' {
    export interface AccountOpeningResponseProps {
        status: boolean;
        response: number;
        message: string;
    }

    export function startAccountOpening(encToken: string, lat: string, lng: string): Promise<AccountOpeningResponseProps>;
}
